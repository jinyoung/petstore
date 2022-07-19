<template>
    <v-card outlined>
        <v-card-title>
            Customer # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <Address offline label="Address" v-model="item.address" :editMode="false" @change="change" />
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'CustomerDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/customers/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
