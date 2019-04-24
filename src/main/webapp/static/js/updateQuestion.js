/**
 *<p>
 *@Description: 发送信息
 *</p>
 *@author ゆず
 *@date 2018/10/22 15:32
 */
function updateQuestion() {
    var questionText = document.getElementById("questionTextArea").value;
    var answerText = document.getElementById("answerTextArea").value;
    var tailNote = document.getElementById("tailNoteArea").value;
    if (questionText === "输入问题..." || questionText.trim().length === 0) {
        alert("请输入问题！");
        return false;
    } else if (answerText === "输入答案..." || answerText.trim().length === 0) {
        alert("请输入答案！");
        return false;
    } else if (tailNote === "输入问题补充..." || tailNote.trim().length === 0) {
        tailNote = "";
    }
    document.getElementById("messageForm").reset();
    var data = {"questionText": questionText, "answerText": answerText, "tailNote": tailNote};
    $.ajax({
        url: "/QuestionController/insertQuestion",
        type: "POST",
        data: data,
        dataType: "json",
        success: function (json) {
            alert(json.detail);
            if (json.result) {
                $("#goHome")[0].click();
            }
        }
    })
}