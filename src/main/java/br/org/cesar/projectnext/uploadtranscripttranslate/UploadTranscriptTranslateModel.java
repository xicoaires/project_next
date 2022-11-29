package br.org.cesar.projectnext.uploadtranscripttranslate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadTranscriptTranslateModel {
    private String transcription;
    private String translation;
    
}
