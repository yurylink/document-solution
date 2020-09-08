package com.yurylink.documentsolution.cotroller;

import com.yurylink.documentsolution.creator.BasicExcelArchiveDto;
import com.yurylink.documentsolution.creator.impl.DtoToExcellCreatorImpl;
import com.yurylink.documentsolution.creator.impl.ExcelBasicCreator;
import com.yurylink.dto.FileDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/web")
public class DocumentSolutionWebController {

    @PostMapping("/input")
    public ResponseEntity<Resource> getExampleDocAsXlsx( @RequestBody FileDto fileDto ){
        BasicExcelArchiveDto dto = new BasicExcelArchiveDto();

        if(fileDto.getFileName().isEmpty())
            dto.setName("Example Archive");

        DtoToExcellCreatorImpl create = new DtoToExcellCreatorImpl(fileDto);

        try {
            ByteArrayInputStream in = create.build();
            final String fileName = dto.getName() + ".xlsx";

            HttpHeaders header = new HttpHeaders();
            header.add("Content-Disposition", "attachment; filename=" + fileName);

            return ResponseEntity.ok().headers(header).body(new InputStreamResource(in));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
