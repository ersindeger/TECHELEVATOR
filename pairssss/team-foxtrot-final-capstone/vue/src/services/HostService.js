import axios from 'axios';

export default {
    listHostEvents(id) {
        return axios.get(`/host/${id}`)
    },

    retrieveHostInfo(id) {
        return axios.get(`/login/${id}`)
    },

    addNewEvent(event) {
        return axios.post('/host/event', event)
    },

    updateEvent(event) {
        return axios.put(`/host/event/${event.eventId}`, event)
    },

    deleteEvent(id) {
        return axios.delete(`/host/event/${id}`)
    },

    retrieveEvent(id) {
        return axios.get(`/host/event/${id}`)
    }
    
}
