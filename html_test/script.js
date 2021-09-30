console.log(5); 
const result = document.querySelector('.result');
function reqOnload () {
  const data = JSON.parse(this.responseText);
  var email =data.results[0].email;
  result.textContent=email;
}
function reqError (err) {
  console.log('錯誤', err)
}
// 宣告一個 XHR 的物件
var request = new XMLHttpRequest(); 
// 定義連線方式
request.open('post', 'http://127.0.0.1:8080/api/plus', true);
// 送出請求
request.send();
// 如果成功就執行 reqOnload()
request.onload = reqOnload; 
// 失敗就 reqError()
request.onerror = reqError;
