<template>
    <div>
        请假审核列表页
        <ul>
            <li v-for="(item,index) in taskList" @click="skipDetailsId(item)" :key="index">请假流程审批</li>
        </ul>
    </div>
</template>

<script>
    export default {
        data:function(){
            return {
                taskList:[]
            }
        },
        created(){
            //获取lisi的任务列表
            this.getTaskList();
        },
        methods:{
            getTaskList(){
                this.$ajax.post("http://127.0.0.1:8080/flowable-modeler/task_list",{assignee:"lisi"})
                .then(res=>{
                    this.taskList = res.data
                })
            },
            skipDetailsId(id){
                this.$router.push({
                    path:"apply_details",
                    query:{
                        taskId:id
                    }
                })
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>