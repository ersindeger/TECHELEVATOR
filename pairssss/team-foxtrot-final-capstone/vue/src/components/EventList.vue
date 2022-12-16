<template>
  <div id="demo">
    <span>
      <h3 id="h3">Upcoming Events</h3>
      <section id="filters">
        <div class="zip_code">
          <input
            type="search"
            class="form-control"
            placeholder="Search By Zip"
            aria-label="Search"
            v-model="zip_code"
          />
        </div>
        <button
          id="showFilter"
          class="btn btn-primary btn-sm showHideFilter"
          type="button"
          variant="outline-primary"
          v-show="hideFilter"
          v-on:click="(showFilter = true), (hideFilter = false)"
        >
          Filter By Type
        </button>

        <div id="resources" v-show="showFilter">
          <button
            type="button"
            class="btn btn-primary btn-sm resourceButton"
            v-for="resource in resource_types"
            v-bind:key="resource.resourceId"
            v-on:click.prevent="
              setResourceFilter(resource.name), toggleActive(resource.name)
            "
          >
            {{ resource.name }}
          </button>
        </div>
        <button
          class="btn btn-primary btn-sm showHideFilter"
          size="sm"
          id="hideFilter"
          type="button"
          v-show="showFilter"
          v-on:click="(showFilter = false), (hideFilter = true)"
        >
          Hide Filters
        </button>
      </section>
    </span>
    <section id="events">
      <event-card
        v-bind:event="event"
        v-for="event in filteredEventList"
        v-bind:key="event.eventId"
        @show-details="onSeeMore(event)"
      />
      <event-modal
        v-if="modal_event"
        :event="modal_event"
        :key="modal_event.id"
        @close="onSeeMoreClose"
      ></event-modal>
    </section>
  </div>
</template>

<script>
import eventService from "../services/EventService.js";
import EventCard from "./EventCard.vue";
import EventModal from "./EventModal.vue";

export default {
  name: "event-list",
  data() {
    return {
      events: [],
      resource_type: "",
      zip_code: "",
      resource_types: this.$store.state.resource_types,
      modal_event: null,
      showFilter: false,
      active: false,
      hideFilter: true,
    };
  },
  components: {
    EventCard,
    EventModal,
  },
  created() {
    eventService.getEvents().then((response) => {
      this.events = response.data.filter((event) => {
        return event.eventDate >= new Date().toLocaleDateString();
      });
    });
  },
  computed: {
    filteredEventList() {
      const eventList = this.events;
      return eventList.filter((event) => {
        if (this.resource_type == "") {
          if (this.zip_code == "") {
            return true;
          }
          return event.address.zip.includes(this.zip_code);
        } else if (this.zip_code == "") {
          return this.resource_type == event.resourceName;
        }
        return (
          this.resource_type == event.resourceName &&
          event.address.zip.includes(this.zip_code)
        );
      });
    },
  },
  methods: {
    setResourceFilter(resource) {
      if (this.resource_type == resource) {
        this.resource_type = "";
      } else {
        this.resource_type = resource;
      }
    },
    onSeeMore(clickedEvent) {
      document.body.classList.add("modal-open");
      this.modal_event = clickedEvent;
      this.stopBodyScroll();
    },
    onSeeMoreClose() {
      document.body.classList.remove("modal-open");
      document.body.style.overflow = "auto";
      this.modal_event = null;
    },
    stopBodyScroll() {
      if (document.body.classList.contains("modal-open")) {
        document.body.style.overflow = "hidden";
      }
    },
    toggleActive(selectedResource) {
      const resources = document.querySelectorAll(".resourceButton");
      resources.forEach((resource) => {
        if (
          resource.innerText == selectedResource &&
          !resource.classList.contains("active")
        ) {
          resource.classList.add("active");
        } else {
          resource.classList.remove("active");
        }
      });
    },
  },
};
</script>

<style scoped>
span {
  display: flex;
  justify-content: space-between;
  border-bottom: solid 2.5px rgb(38, 242, 255);
  flex-wrap: nowrap;
}

#filters {
  display: inline-flex;
  gap: 20px;
  align-items: center;
}

#showFilter {
  outline: none !important;
}

#events {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  margin-top: 20px;
}

#resources {
  display: inline-flex;
  flex-shrink: 4;
  flex-wrap: wrap;
  gap: 10px;
}

h3 {
  padding: 1%;
  margin-left: 2px;
  margin-bottom: 3px;
  align-items: center;
  justify-content: flex-start;
}

#resources button {
  border: none;
  text-align: center;
  display: inline-block;
  background: #ba9bdf;
}

.active {
  background: #8952c7 !important;
}

.showHideFilter {
  background-color: #d1ffeb !important;
  border: #a4ffd8 3px outset !important;
  color: black;
}

.showHideFilter:hover {
  color: black;
}

.form-control {
  border: rgb(38, 242, 255) 2px outset !important;
}

.btn {
  border-radius: 23px;
  border: none;
}

.modal-open {
  overflow: hidden;
  position: fixed;
}

.form-outline {
  width: 250px;
  margin: 2% 0 3% 10%;
}

.zip_code {
  width: 20vw;
}
</style>