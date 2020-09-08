package com.yurylink.documentsolution.creator.impl;

import com.yurylink.documentsolution.creator.AbstractExcelConciliationReportBuilder;
import com.yurylink.dto.FileDto;

import java.util.Arrays;
import java.util.List;

public class DtoToExcellCreatorImpl extends AbstractExcelConciliationReportBuilder<FileDto> {

    public DtoToExcellCreatorImpl(final FileDto dto) {
        super(dto);
    }

    @Override
    public String getTitleText() {
        return dto.getTitle();
    }

    @Override
    public String getSubTitleText() {
        return dto.getSubtitle();
    }

    @Override
    public List<String> getHeader() {
        String[] listOfString = Arrays.stream(dto.getHeader().split(",")).toArray(String[]::new);
        return Arrays.asList(listOfString);
    }

    @Override
    protected void buildBody() {
        dto.getBody().forEach(s -> {
            if(s.equals("lineseparator")){
                builder.addLineSeparatorSection("");
            }else{
                String[] listOFValues = Arrays.stream(s.split(",")).toArray(String[]::new);
                Arrays.asList(listOFValues).forEach(s1 -> builder.addCell(s1));
            }
            builder.newRowFillEmptyCell();
        });
    }


}
