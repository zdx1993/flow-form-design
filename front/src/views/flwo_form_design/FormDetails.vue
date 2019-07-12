<template>
    <div>
        表单设计页面
        <el-button type="danger" @click="dialogVisible = true" plain>新增表单项</el-button>
        <el-button type="success" plain @click="storeForm">保存表单</el-button>
        <hr>
        <div v-if="FormRanderData != ''">
            <FormRander :formJsonData="FormRanderData" :isDesign="true"></FormRander>
        </div>


        <!-- 新增表单项对话框---开始 -->
        <el-dialog title="新增表单项" :visible.sync="dialogVisible" width="40%">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="表单标题">
                    <el-input v-model="form.formLabel"></el-input>
                </el-form-item>
                <el-form-item label="表单类型">
                    <el-select v-model="form.formType" placeholder="请选择活动区域">
                        <el-option label="文本框" value="text"></el-option>
                        <el-option label="日期框" value="date"></el-option>
                        <el-option label="按钮" value="button"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="表单属性">
                    <el-input v-model="form.formProperties"></el-input>
                </el-form-item>
                <!-- <el-form-item label="默认值">
                    <el-input placeholder="没有的话可以不填" v-model="form.formValue"></el-input>
                </el-form-item> -->
                <el-form-item label="是否只读">
                    <el-switch v-model="form.canChange"></el-switch>
                </el-form-item>
                <el-form-item label="描述">
                    <el-input type="textarea" v-model="form.formDesc"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addFormItem">确 定</el-button>
            </span>
        </el-dialog>
        <!-- 新增表单项对话框---结束 -->
    </div>
</template>

<script>
    import FormRander from '../../components/FormRander'
    export default {
        name: "formDesignPage",
        components: {
            FormRander: FormRander
        },
        data: function () {
            return {
                FormRanderData: '',
                dialogVisible: false,
                form: {
                    formLabel: '',
                    formType: '',
                    formProperties: '',
                    canChange: false,
                    formValue: "",
                    formDesc: ''
                }
            }
        },
        created() {
            this.init();
        },
        methods: {
            init() {
                this.getFormDetails(this.$route.query.id);
            },
            getFormDetails(id) {
                this.$ajax.get("/admin_form/details", {
                        params: {
                            id: id
                        }
                    })
                    .then(res => {
                        if (res.data.code == 200) {
                            this.FormRanderData = res.data.content
                            if (this.FormRanderData.content == null) {
                                this.FormRanderData.content = [];
                            }else{
                                this.FormRanderData.content = JSON.parse(this.FormRanderData.content);
                            }
                        }
                    })
            },
            addFormItem() { //新增表单项目
                let inputDate = this.form;
                inputDate.canChange = inputDate.canChange ? "0" : "1";
                debugger
                inputDate.formValue = "${" + inputDate.formProperties + "}"
                this.FormRanderData.content.push(inputDate);
                this.dialogVisible = false;
                this.form = {
                    formLabel: '',
                    formType: '',
                    formProperties: '',
                    canChange: false,
                    formValue: "",
                    formDesc: ''
                };
            },
            storeForm() { //保存表单内容
                let sendDate = this.FormRanderData;
                sendDate.content = JSON.stringify(sendDate.content);
                delete sendDate.createDate;
                delete sendDate.updateDate;
                this.$ajax.post("/admin_form/update_item", sendDate)
                    .then(res => {
                        if (res.data.code == 200) {
                            this.$alert("保存表单成功")
                        }
                    })
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>