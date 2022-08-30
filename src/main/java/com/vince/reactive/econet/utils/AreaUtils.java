package com.vince.reactive.econet.utils;

import com.vince.reactive.econet.dto.AreaDto;
import com.vince.reactive.econet.model.Area;
import org.springframework.beans.BeanUtils;

public class AreaUtils {

    public static AreaDto entityToDto(Area area){
        AreaDto areaDto = new AreaDto();
        BeanUtils.copyProperties(area, areaDto);
        return areaDto;
    }

    public static Area dtoToEntity(AreaDto areaDto){
        Area area = new Area();
        BeanUtils.copyProperties(areaDto, area);
        return area;
    }
}
