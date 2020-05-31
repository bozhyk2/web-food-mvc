

function changeFoodType(){
	
	var selectElem = document.getElementById("selectType");
	var selectedOpt ="";
	var addOpt = document.getElementById("addTypeOption");
	var selectOpt = document.getElementById("selectTypeOption");
	selectElem.onchange = function(){
		selectedOpt = selectElem.options[selectElem.selectedIndex];
		if (selectedOpt==addOpt){
			document.getElementById("enterType").value=""; 
			document.getElementById("showChoisedType").style.display="block";
		}else if (selectedOpt==selectOpt){
			document.getElementById("enterType").value=""; 
			document.getElementById("showChoisedType").style.display="none";
		}else{
			document.getElementById("enterType").value = selectedOpt.value; 
			document.getElementById("showChoisedType").style.display="none";
		}
	
	}	
	document.getElementById("showChoisedType").style.display="none";	
}

window.onload = function(){

	changeFoodType();
};