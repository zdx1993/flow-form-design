<template>
    <div>
        请假审核详情页
        <FormRander :formJsonData="randerDate"></FormRander>
    </div>
</template>

<script>
import FormRander from '../../../components/FormRander'
    export default {
        name: "applyDetails",
        components: {
            FormRander: FormRander
        },
        data: function () {
            return {
                taskId: this.$route.query.taskId,
                randerDate: {}
            }
        },
        created() {
            this.getTaskForm();
        },
        methods: {
            getTaskForm() {
                this.$ajax.get('/form/task', {
                        params: {
                            taskId: this.taskId
                        }
                    })
                    .then(res => {
                        this.randerDate = res.data.content
                        this.randerDate.content = JSON.parse(res.data.content.content)
                    })
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>