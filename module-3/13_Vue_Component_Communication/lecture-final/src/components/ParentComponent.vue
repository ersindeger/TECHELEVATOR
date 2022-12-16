<template>
  <div>
      <h1>I am a parent</h1>
      <child-component haircolor="brown" />
      <child-component haircolor="blonde" />
  </div>
</template>

<script>

import ChildComponent from "./ChildComponent.vue";

export default {
    name: 'parent-component',
    components: {
       ChildComponent
  },

}
</script>

<style>

</style>