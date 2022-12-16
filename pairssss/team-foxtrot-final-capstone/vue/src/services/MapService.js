import axios from 'axios'

export default {
    getCoordinates(location) {
        return axios.get(
        `http://nominatim.openstreetmap.org/search?q=${location}&format=json&polygon=1&addressdetails=1`
      )
    }
}
