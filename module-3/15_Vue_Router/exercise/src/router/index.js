import Vue from 'vue';
import VueRouter from 'vue-router';
import BestSellerList from '../components/BestSellerList.vue'
import NewReleasesList from '../components/NewReleasesList.vue'
import ReadingList from '../components/ReadingList.vue'
import NewBookForm from '../components/NewBookForm.vue'

Vue.use(VueRouter);

const routes = [

  {
    path: '/',
    name: 'bestsellers',
    component: BestSellerList
  },
  {
    path: '/',
    name: 'newreleases',
    component: NewReleasesList
  },
  {
    path: '/myBooks',
    name: 'readinglist',
    component: ReadingList
  },
  {
    path: '/addBook',
    name: 'newbookform',
    component: NewBookForm
  }




];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
