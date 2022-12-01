package br.org.cesar.projectnext.uploadtranscripttranslate;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.org.cesar.projectnext.cloudstorage.UploadFileToStorageService;
import br.org.cesar.projectnext.cloudtranscription.CloudTranscriptionService;
import br.org.cesar.projectnext.cloudtranslate.TranslateTextUtil;

//Classe com a rota com a intergração das 3 APIs.
@RestController
public class UploadTranscriptTranslateController {
    @PostMapping("/projectnext")
    public ResponseEntity<UploadTranscriptTranslateModel> uploadTranscriptTranslate (@RequestParam("file") MultipartFile multipartFile) throws IOException{
        String filename = multipartFile.getOriginalFilename();
        UploadFileToStorageService.uploadFile(multipartFile);

        UploadTranscriptTranslateModel text = new UploadTranscriptTranslateModel();
        text.setTranscription(CloudTranscriptionService.transcriptionFile(filename));
        text.setTranslation(TranslateTextUtil.translateTextEn(text.getTranscription()));
        
        return new ResponseEntity<>(text, HttpStatus.OK);
    } 
}