<template>
    <div class="board-detail">
        <div class="common-buttons">
            <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnUpdate">수정</button>&nbsp;
            <button type="button" class="w3-button w3-round w3-red" n-on:click="fnDelete">삭제</button>&nbsp;
            <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
        </div>
        <div class="board-contents">
            <h3>{{ title }}</h3>
            <div>
                <strong class="w3-large">{{ author }}</strong>
                <br>
                <span>{{ created_at }}</span>
            </div>
        </div>
        <div class="board-contents">
            <span>{{ contents }}</span>
        </div>
        <div class="common-buttons">
            <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnUpdate">수정</button>&nbsp;
            <button type="button" class="w3-button w3-round w3-red" v-on:click="fnDelete">삭제</button>&nbsp;
            <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            requestBody: this.$route.query,
            idx: this.$route.query.idx,

            title: '',
            author: '',
            contents: '',
            created_at:''
        }
    },
    mounted() {
        this.fnGetView()
    },
    methods: {
        fnGetView() {
            this.$axios.get(this.$serverUrl + '/board/' + this.idx, {
                params: this.requestBody
            }).then((res) => {
                console.log(res)
                this.title = res.data.title
                this.author = res.data.author
                this.contents = res.data.contents
                this.created_at = res.data.created_at
            }).catch((err) => {
                if (err.message.indexOf('Network error') > -1) {
                    alert('네트워크가 원할하지 않습니다.\n잠시 후 다시 시도해주세요')
                }
            })
        },
        fnList(){
            delete this.requestBody.idx
            // console.log("this.requestBody" + '%o',this.requestBody);
            this.$router.push({
                path:'./list',
                query: this.requestBody
            })
        },
        fnUpdate(){
            this.$router.push({
                path:'./write',
                query: this.requestBody
            })
        }
    }
}
</script>