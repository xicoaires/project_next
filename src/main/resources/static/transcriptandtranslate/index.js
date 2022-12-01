async function uploadFile() {
  let formData = new FormData(); 
  formData.append("file", inputGroupFile04.files[0]);
  let response = await fetch('/projectnext', {
    method: "POST", 
    body: formData
  }).then (response => {
    return response.json();
  })
  .then ( json => {
    $(".modal-body").show();
    $(".transcription").text(json.transcription);
    $(".translation").text(json.translation);
})
}

