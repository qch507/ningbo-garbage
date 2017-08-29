/**
 * Created by qiuch on 2017/8/14.
 */

function showModeladd() {
    $("#input_cname").val("");
    // $("#inputSelect").val("");
    $("#cid").val("");
    $("#myModal").modal();
};

function showModeledit(cname, pname, id) {
    $("#input_cname").val(cname);
    $("#inputSelect").val(pname);
    $("#cid").val(id);
    $("#myModal").modal();
};