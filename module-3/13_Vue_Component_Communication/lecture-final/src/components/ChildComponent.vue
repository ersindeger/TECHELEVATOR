<template>
  <div>

      <h1>I am a child and I have {{haircolor}} hair!</h1>
      <p>My favorite ice cream is:{{iceCream}}</p>

  </div>
</template>

<script>
export default {
    name: 'child-component',
    props: ["haircolor"],
    data() {
        return {
            iceCream: 'Cookies and Cream'
        }
    }

}
</script>

<style>

</style>