package com.wu.boot.configuration.selector;

import com.wu.boot.annotation.EnableCaching;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CachingConfigurationSelector extends  AdviceModeImportSelector<EnableCaching>{
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        String[] imports = super.selectImports(metadata);
        return imports;
    }
}
