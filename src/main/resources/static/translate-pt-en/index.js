async function translateText() {
  let text = $("#floatingTextarea").val();  
  await fetch('/PtToEn', {
    method: "POST", 
    body: JSON.stringify({text})
  }).then (response => {
    return response.json();
  })
  .then ( json => {
    $(".modal-body").show();
    $(".translation").text(json.text);
})
}