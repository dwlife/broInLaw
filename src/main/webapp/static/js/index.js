/**
 * <p>
 * @author hiYuzu
 * @description index
 * @version V1.0
 * </p>
 * @date 2018/11/16 10:00
 */
$(function () {
    $.ajax({
        url: "/QuestionController/getQuestion",
        type: "post",
        dataType: "json",
        success: function (json) {
            if (json.result) {
                document.getElementById("question").innerText = json.rows[0].questionText;
                document.getElementById("answer").innerText = json.rows[0].answerText;
                document.getElementById("tailNote").innerText = json.rows[0].tailNote;
            }
        }
    });
});

function insertAnswer(input) {
    $.ajax({
        url: "/AnswerController/insertAnswer",
        type: "POST",
        data: {
            "answerText": input
        },
        dataType: "json",
        success: function (json) {
        }
    });
}

function getAnswer() {
    var input = $("#inputDiv").val();
    if (input != null && input != "") {
        insertAnswer(input);
        $("#answer").css("display", "");
    } else {
        alert("请输入您的答案");
        return false;
    }
}