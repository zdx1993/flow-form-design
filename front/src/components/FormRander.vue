<template>
    <div>
        <h3>表单名称:{{formJsonData.name}}</h3>
        <h5>表单介绍:{{formJsonData.desc}}</h5>
        <h5 v-if="isDesign">外置表单key:{{formJsonData.id}}</h5>
        <!-- <h5>上次修改时间{{formJsonData.updateDate}}</h5> -->
        <div v-for="(item,index) in formJsonData.content" :key="index">
            <div v-if="item.formType == 'text'">
                <span>{{item.formLabel}}:</span>
                <!-- 设计场景 -->
                <template v-if="isDesign">
                    <el-input :disabled="item.canChange == '0' ? true:false" value="" placeholder="请输入内容"></el-input>
                </template>
                <!-- 非设计场景 -->
                <template v-else>
                    <el-input :disabled="item.canChange == '0' ? true:false" v-model="item.formValue"
                        placeholder="请输入内容"></el-input>
                </template>
            </div>
            <div v-if="item.formType == 'date'">
                <span>{{item.formLabel}}:</span>
                <el-date-picker :disabled="item.canChange == '0' ? true:false" v-model="item.formValue"
                    value-format="timestamp" type="datetime" placeholder="选择日期时间">
                </el-date-picker>
            </div>
            <div v-if="item.formType == 'button'">
                <template v-if="item.formProperties == 'reject'">
                    <el-button @click="formButton('reject')" type="danger" plain>驳回</el-button>
                </template>
                <template v-if="item.formProperties == 'accept'">
                    <el-button @click="formButton('accept')" type="success" plain>通过</el-button>
                </template>
                <template v-if="item.formProperties == 'start'">
                    <el-button @click="formButton('start')" type="primary" plain>提交表单</el-button>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "formRanderComponent", //表单渲染组件
        props: {
            isDesign: {
                default: false
            },
            isStart: {
                default: false
            },
            formJsonData: {}
            /**
             * 暂时能配置的表单有文本框
             * 1.text---文本框
             * 2.date---时间选项
             * 3.button---按钮
             * 构建form表单的数据结构为
             * [{
             *  formType:"text",
             *  formLabel:"请假原因",
             *  formProperties:"cause",
             *  formValue:"",
             *  canChange:"1",     //是否可变,不可变的数据也不能提交到流程变量中!
             *  formDesc:""
             * }]
             */
        },
        data: function () {
            return {}
        },
        created() {
            // console.log(this.formJsonData)
            // this.formContent = this.formJsonData.content;
        },
        methods: {
            formButton(buttonType) {
                let sernData = {};
                this.formJsonData.content.forEach(element => {
                    sernData[element.formProperties] = element.formValue
                });
                if (buttonType == "reject") {
                    sernData.isPass = 0;
                    sernData.taskId = this.$route.query.taskId
                    this.$ajax.post("http://127.0.0.1:8080/flowable-modeler/complate_task_by_taskId", sernData)
                        .then(res => {
                            this.$router.push("demo_entry")
                        })

                } else if (buttonType == "accept") {
                    sernData.isPass = 1;
                    sernData.taskId = this.$route.query.taskId
                    this.$ajax.post("http://127.0.0.1:8080/flowable-modeler/complate_task_by_taskId", sernData)
                        .then(res => {
                            this.$router.push("demo_entry")
                        })

                } else if (buttonType == "start") {
                    sernData.processKey = this.$route.query.processKey
                    this.$ajax.post("http://127.0.0.1:8080/flowable-modeler/start_process", sernData)
                        .then(res => {
                            this.$router.push("demo_entry")
                        })
                }
            }
        }

    }
</script>

<style lang="scss" scoped>

</style>