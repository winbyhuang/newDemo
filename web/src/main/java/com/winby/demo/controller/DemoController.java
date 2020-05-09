package com.winby.demo.controller;

import com.winby.demo.common.constant.SysConstants;
import com.winby.demo.common.util.GsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/10/13.
 */
@RequestMapping("common")
@RestController
@Log4j2
public class DemoController {
//    @Autowired
//    private DemoService demoService;

    @RequestMapping("test")
    Object save(HttpServletRequest request, String msg) throws Exception {
        log(Thread.currentThread().getStackTrace()[1].getMethodName(), request.getAttribute(SysConstants.REQUEST_REMARK) + GsonUtil.toJson(msg));
        return msg;
    }
//    @PostMapping("save.do")
//    ResultEntity save(HttpServletRequest request, DemoDO entity) throws Exception {
//        ResultEntity result = new ResultEntity(ResultEntity.SUCCESS);
//        entity.setCreator("1233");
//        ResultDTO<Integer> resultDTO = demoService.save(entity);
//        if (!resultDTO.isSuccess()) {
//            throw new GenericException(resultDTO.getErrorDetail());
//        }
//        log(Thread.currentThread().getStackTrace()[1].getMethodName(), request.getAttribute(SysConstants.REQUEST_REMARK) + GsonUtil.toJson(result));
//        return result;
//    }

//    @PostMapping("delete.do")
//    ResultEntity delete(HttpServletRequest request, DemoDO entity) {
//        ResultEntity result = new ResultEntity(ResultEntity.SUCCESS);
//        entity.setModifier("1233");
//        ResultDTO<Integer> resultDTO = demoService.remove(entity);
//        if (!resultDTO.isSuccess()) {
//            throw new GenericException(resultDTO.getErrorDetail());
//        }
//        log(Thread.currentThread().getStackTrace()[1].getMethodName(), request.getAttribute(SysConstants.REQUEST_REMARK) + GsonUtil.toJson(result));
//        return result;
//    }
//
//    @PostMapping("modify.do")
//    ResultEntity modify(HttpServletRequest request, DemoDO entity) {
//        ResultEntity result = new ResultEntity(ResultEntity.SUCCESS);
//        entity.setModifier("123");
//        ResultDTO<Integer> resultDTO = demoService.modify(entity);
//        if (!resultDTO.isSuccess()) {
//            throw new GenericException(resultDTO.getErrorDetail());
//        }
//        log(Thread.currentThread().getStackTrace()[1].getMethodName(), request.getAttribute(SysConstants.REQUEST_REMARK) + GsonUtil.toJson(result));
//        return result;
//    }
//
//    @PostMapping("getById.do")
//    ResultEntity getById(HttpServletRequest request, Long id) {
//        ResultEntity result = new ResultEntity(ResultEntity.SUCCESS);
//        ResultDTO<DemoDO> resultDTO = demoService.getById(id);
//        result.setResult(resultDTO.getModule());
//        if (!resultDTO.isSuccess()) {
//            throw new GenericException(resultDTO.getErrorDetail());
//        }
//        log(Thread.currentThread().getStackTrace()[1].getMethodName(), request.getAttribute(SysConstants.REQUEST_REMARK) + GsonUtil.toJson(result));
//        return result;
//    }
//
//    @GetMapping("list.do")
//    ResultEntity list(HttpServletRequest request, DemoDO entity) {
//        ResultEntity result = new ResultEntity(ResultEntity.SUCCESS);
//        BatchResultDTO<DemoDO> batchResultDTO = demoService.list(entity);
//        result.setResult(batchResultDTO.getModule());
//        log(Thread.currentThread().getStackTrace()[1].getMethodName(), request.getAttribute(SysConstants.REQUEST_REMARK) + GsonUtil.toJson(result));
//        return result;
//    }
//
//    @RequestMapping(value = "/a", method = RequestMethod.GET)
//    public Map<String, Object> firstResp(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        WebSocketUtil.sendSome("ss", WebSocketUtil.userMap);
//        session.setAttribute("aa", "dddd");
////        RedisUtil.set("ss","11");
////        System.out.println(RedisUtil.get("ss"));
//        Map<String, Object> map = new HashMap<String, Object>();
//        request.getSession().setAttribute("requestUrl", request.getRequestURL());
//        map.put("sessionId", request.getSession().getId());
//        map.put("requestUrl", request.getRequestURL());
//        map.put("aa", session.getAttribute("aa"));
//        return map;
//    }
//
//    @RequestMapping(value = "/b", method = RequestMethod.GET)
//    public Object sessions(HttpSession session, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("sessionId", request.getSession().getId());
//        map.put("message", request.getSession().getAttribute("requestUrl"));
//        map.put("aa", session.getAttribute("aa"));
//        return map;
//    }

    final void log(String methodName, String result) {
        log.info("{}:{}", methodName, result);
    }
}

