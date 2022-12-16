import axios from 'axios';

export default {
    search() {
        return axios.get('/homes')
    }

    // addAHome (home) {
    //     return axios.post(home);
    // }
}