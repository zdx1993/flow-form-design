<template>
    <div>
        <el-button type="warning" @click="applyLeave" plain>申请请假</el-button>
    </div>
</template>

<script>
    export default {
        data:function(){
            return {

            }
        },
        methods:{
            applyLeave(){
                this.$router.push({
                    path:"/start_page",
                    query:{
                        processKey:"test-outside-form"
                    }
                })
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>