async function translateText() {
  let text = $("#floatingTextarea").val();  
  await fetch('/EnToPt', {
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

