<template>
    <v-card outlined>
        <v-card-title>
            Item # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Type" v-model="item.type" :editMode="editMode" @change="change" />
            </div>
            <Money offline label="Price" v-model="item.price" :editMode="false" @change="change" />
            <PetId offline label="PetId" v-model="item.petId" :editMode="false" :key="false" @change="change" />
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'ItemDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/items/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
