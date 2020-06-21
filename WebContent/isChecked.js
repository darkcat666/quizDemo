function isCheckedRadio() {
	var isDisabled;

	if (document.form1.answer[0].checked ||
			document.form1.answer[1].checked ||
			document.form1.answer[2].checked ||
			document.form1.answer[3].checked) {
		isDisabled = false;
	} else {
		isDisabled = true;
	}
	document.getElementById("checkAns").disabled = isDisabled;
}