<template>
  <div class="nice-padding">
    <p>
      <v-btn color="primary" :to="{ name: 'dmp-create'}">Create new DMP</v-btn>
    </p>
    <v-card>
      <v-card-title>
        MyDMPs
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="search"
          label="Search DMPs..."
          single-line
          hide-details
          outline
        ></v-text-field>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="dmp.dmps"
        :expand="expand"
        :search="search"
        >
        <template slot="items" slot-scope="props">
          <tr @click="props.expanded = !props.expanded" class="text-xs-left">
            <td><router-link :to="{ name: 'dmp-show', params: { id: props.item.id }}">{{ props.item.id }}</router-link></td>
            <td>{{ props.item.researchProjects.length }}</td>
            <td><a :href="'mailto:' + props.item.contactPerson.email">
              {{ props.item.contactPerson.firstName }}  {{ props.item.contactPerson.lastName }}</a>
            </td>
            <td>{{ props.item.created | formatDateTime }}</td>
            <td>{{ props.item.lastUpdate | formatDateTime }}</td>
          </tr>
        </template>
        <template slot="expand" slot-scope="props">
          <ProjectPreview v-for="project in props.item.researchProjects" :key="project.id" :project="project"/>
        </template>
      </v-data-table>
    </v-card>
  </div>
</template>

<script>
import store from '@/store/store'
import { mapState } from 'vuex'
import ProjectPreview from '@/components/ProjectPreview.vue'

function getDmps (routeTo, next) {
  store.dispatch('dmp/fetchDmps')
    .then(() => {
      next()
    })
}

export default {
  name: 'MyDmps',
  components: { ProjectPreview },
  data () {
    return {
      search: '',
      expand: true,
      headers: [
        { text: 'ID', value: 'id' },
        { text: 'Projects', value: '' },
        { text: 'Contact', value: 'contactPerson.lastName' },
        { text: 'Created', value: 'created' },
        { text: 'Last Update', value: 'lastUpdate' }
      ]
    }
  },
  beforeRouteEnter (routeTo, routeFrom, next) {
    getDmps(routeTo, next)
  },
  beforeRouteUpdate (routeTo, routeFrom, next) {
    getDmps(routeTo, next)
  },
  computed: {
    ...mapState(['dmp'])
  }
}
</script>

<style scoped>
.nice-padding{
  padding: 20px;
}

</style>
