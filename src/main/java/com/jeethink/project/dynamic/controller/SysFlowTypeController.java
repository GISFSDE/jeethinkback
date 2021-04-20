package com.jeethink.project.dynamic.controller;


import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.project.dynamic.domain.SysFlowType;
import com.jeethink.project.dynamic.service.SysFlowTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/system/formtype")
public class SysFlowTypeController extends BaseController {
    @Autowired
    private SysFlowTypeService typeService;

//  @PreAuthorize("@ss.hasPermi('system:dynamic:list')")
    @GetMapping("/list")
    public AjaxResult list(SysFlowType formtype) {
        List<SysFlowType> flowTypes = typeService.selectTypeList(formtype);
        return AjaxResult.success(flowTypes);
    }

    @GetMapping("/listType")
    public AjaxResult listtype(SysFlowType formtype) {
        List<SysFlowType> flowTypes = typeService.selectType(formtype);
        return AjaxResult.success(flowTypes);
    }

//    @PreAuthorize("@ss.hasPermi('system:dynamic:add')")
    @Log(title = "事件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SysFlowType formtype) {
        return toAjax(typeService.insertType(formtype));
    }

    //    @PreAuthorize("@ss.hasPermi('system:dynamic:add')")
    @Log(title = "事件管理", businessType = BusinessType.UPDATE)
//    @PutMapping("/update")
    @PutMapping
    public AjaxResult update(@RequestBody SysFlowType formtype) {
        return toAjax(typeService.updateType(formtype));
    }

    //    @PreAuthorize("@ss.hasPermi('system:dynamic:add')")
    @Log(title = "事件管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable String id) {
        return toAjax(typeService.deleteTypeById(id));
    }
}