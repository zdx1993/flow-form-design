<template>
    <div class="form-list-page">
        <div class="dd-one">
            <el-row>
                <el-button @click="addFormDialog = true" type="primary">新增表单</el-button>
            </el-row>
        </div>
        <div class="dd-two" v-if="list.length != 0">
            <div @click="skipFormDeatils(item.id)" v-for="(item,index) in list" :key="index">
                <span>{{item.name}}</span>
            </div>
        </div>
        <div v-else>
            无表单数据
        </div>
        <!-- 新增表单弹出框开始 -->
        <el-dialog title="创建表单" :visible.sync="addFormDialog" width="50%">
            <div class="dd-form-content">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="表单名称">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="表单描述">
                        <el-input type="textarea" v-model="form.desc"></el-input>
                    </el-form-item>
                </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addFormDialog = false">取 消</el-button>
                <el-button type="success" @click="addFormItem">立即创建</el-button>
            </span>
        </el-dialog>
        <!-- 新增表单弹出框结束 -->
    </div>
</template>

<script>
    export default {
        name: "formListPage", //表单浏览页面,用于浏览设计好的表单以及,新增表单
        data: function () {
            return {
                addFormDialog: false,
                list:[],
                form: {
                    name: '',
                    desc: ''
                }
            }
        },
        created() {
            this.init();
        },
        methods: {
            init() {
                //获取列表数据
                this.getListInfo();
            },
            getListInfo() { //获取列表数据
                //暂不实现
                this.$ajax.get("/admin_form/form_list")
                .then(res => {
                    if(res.data.code == 200){
                        this.list = res.data.content;
                    }
                })
            },
            addFormItem(){ //新增一个表单项
                this.$ajax.post("/admin_form/add_form_item",this.form)
                .then(
                    res => {
                        if(res.data.code == 200){
                            //从新渲染列表数据
                            this.getListInfo();
                            this.$alert("操作成功");
                            this.addFormDialog = false;
                        }
                    })
            },
            skipFormDeatils(id){ //进入表单设计页面
                this.$router.push({
                    name:"form_details",
                    query:{
                        "id":id
                    }
                })
            }
        }
    }
</script>

<style lang="scss" scoped>
    .line{
        text-align: center;
    }
</style>