/**
 * Created by qiuch on 2017/8/10.
 */
function check_submit() {
    var question = $("textarea[name='question']").val();
    if (question.length < 1) {
        alert("提问不能为空");
        return false;
    }
    return true;

}
$(function () {
    $(".listbox a").click(function (e) {
        var type = $(this).attr("class");
        $.post("/classifaction", {type: type}, function (data) {
            var jsondata = eval('(' + data + ')');
            if (jsondata.success == 1) {
                $('#goodcover').show();
                $('#code').css({'top': ($(window).height() - $('#code').height()) / 2}).fadeIn();
                $("#text_content").html("属于" + jsondata.cat_title + "<br/>" + jsondata.cat_description);
            } else {
                alert(jsondata.msg);
            }
            return false;
        });
    });

    $(".go_check").click(function (e) {
        var keywords = $("#keywords").val();
        if (keywords.length < 1) {
            alert("请输入搜索品名");
            return false;
        }
        $.post("/search", {keywords: keywords}, function (data) {
            var jsondata = eval('(' + data + ')');
            if (jsondata.success == 1) {
                $('#goodcover').show();
                $('#code').css({'top': ($(window).height() - $('#code').height()) / 2}).fadeIn();
                $("#text_content").html("属于" + jsondata.cat_title + "<br/>" + jsondata.cat_description);
            } else {
                $('#goodcover').show();
                $('#code').css({'top': ($(window).height() - $('#code').height()) / 2}).fadeIn();
                $("#text_content").html(jsondata.msg);
            }
            return false;
        });
    });
    $('.listt').click(function (event) {
        if ($('.listbox').css('display') == 'none') {
            $('.listbox').show();
        }
        else {
            $('.listbox').hide();
        }
    });
    $(".myask").click(function (e) {

        $(".myasks").toggle();
    });
//    $('.search .go').click(function() {
//
//        $('#goodcover').show();
//        $('#code').css({'top':($(window).height()-$('#code').height())/2}).fadeIn();
//        return false;
//    });
    $('#closebt').click(function () {
        $('#code').hide();
        $('#goodcover').hide();
    });
    $('#goodcover').click(function () {
        $('#code').hide();
        $('#goodcover').hide();
    });

})