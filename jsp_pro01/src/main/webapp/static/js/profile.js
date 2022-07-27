const imgSelect = document.querySelector("#imgSelect");
const previewImg = document.querySelector("#previewImg");

previewImg.addEventListener("click", function(e) {
	imgSelect.click();
});
imgSelect.addEventListener("change", ajaxImageUpload);


function showImagePreview(e) {
	var file = e.target.files[0];
	var imgUrl = URL.createObjectURL(file);
	previewImg.src = imgUrl;
}

function ajaxImageUpload(e) {
	var file = e.target.files[0];
	var fData = new FormData();
	fData.append("uploadImage", file, file.name);
		
	$.ajax({
		type: "post",
		enctype: "multipart/form-data",
		url: "/jsp01/ajax/imgeUpload",
		data: fData,
		processData: false,
		contentType: false,
		success: function(data, status) {
			previewImg.src = data.src;
		}
	});
}