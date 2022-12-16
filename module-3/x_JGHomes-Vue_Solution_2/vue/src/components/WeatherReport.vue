<template>
  <div>
      <p>Weather Report:</p>
      <div>{{weather}}</div>
  </div>
</template>

<script>
export default {
    name: "weather-report",

    data() {

        return {

            weather: '',
         //   weatherArray: ''
        }
    },
    created() {
        //http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2f7bdcc26bc9669ab55f8341c4521509
        fetch('http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2f7bdcc26bc9669ab55f8341c4521509').then( response => {
            if (response.status !== 200) {
                console.log('Oops ' + response.status)
                return;
            }

            response.json().then( data => {

                this.weather = data;
               // this.weatherArray = this.weather.weather;
            })

        })
    }

}
</script>

<style>

</style>