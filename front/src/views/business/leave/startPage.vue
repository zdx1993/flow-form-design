<template>
    <div>
        流程启动页面
        <FormRander :formJsonData="randerDate"></FormRander>
    </div>
</template>

<script>
    import FormRander from '../../../components/FormRander'
    export default {
        name: "startPage", //表单渲染组件
        components: {
            FormRander: FormRander
        },
        data:function(){
            return {
                processKey:this.$route.query.processKey,
                randerDate:{}
            }
        },
        created(){
            this.init();
        },
        methods:{
            init(){
                this.getInitForm();
            },
            //获取启动表单信息
            getInitForm(){
                this.$ajax.get("/form/init",{params:{processKey:this.processKey}})
                .then( res=>{
                    if(res.data.code == 200){
                        this.randerDate = res.data.content
                        this.randerDate.content = JSON.parse(res.data.content.content);
                    }
                } )
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>