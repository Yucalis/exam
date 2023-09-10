package com.mz.auth.web.controller;

import com.mz.auth.entity.*;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.service.DicService;
import com.mz.auth.service.PaperQuestionService;
import com.mz.auth.service.PaperService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "在线考试系统-试卷管理接口")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private DicService dicService;

    @Autowired
    private PaperQuestionService paperQuestionService;

    @RequestMapping("/paper/queryPaper")
    @ResponseBody
    public List<Paper> findAll() {
        return paperService.findAll();
    }

    @GetMapping("/paper/index")
    public String index(Model model) {
        List<DicTypeData> levels = dicService.findLevels();
        model.addAttribute("levels", levels);
        return "views/paper/paper_list";
    }

    @RequestMapping("/paper/listpage")
    @ResponseBody
    public PageList listpage(PaperQuery paperQuery) {
        return paperService.listpage(paperQuery);
    }

    /**
     * 新增试卷
     * @param paper
     * @return
     */
    @PostMapping("/paper/savePaper")
    @ResponseBody
    public MzResult savePaper(Paper paper) {
        try {
            paperService.savePaper(paper);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    /**
     * 修改保存试卷
     * @param paper
     * @return
     */
    @PostMapping("/paper/editSavePaper")
    @ResponseBody
    public MzResult editSavePaper(Paper paper) {
        try {
            paperService.editSavePaper(paper);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    /**
     * 根据id删除试卷
     * @param id
     * @return
     */
    @PostMapping("/paper/deletePaper")
    @ResponseBody
    public MzResult deletePaper(Long id) {
        try {
            paperService.deletePaper(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @RequestMapping("/paper/appendQuestion")
    public String appendQuestion() {
        return "views/paper/paper_question";
    }

    @PostMapping("/paper/queryQuestionByPaperId")
    @ResponseBody
    public List<PaperQuestion> queryQuestionByPaperId(@RequestBody PaperQuestion paperQuestion) {
        return paperQuestionService.queryQuestionByPaperId(paperQuestion.getPaperId());
    }



    @PostMapping("/paper/diyPaperQuestion")
    @ResponseBody
    public MzResult diyPaperQuestion(@RequestBody PaperQuestion paperQuestion) {
        try {
            paperQuestionService.diyPaperQuestion(paperQuestion);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @RequestMapping("/paper/previewPaper/{paperId}")
    public String previewPaper(@PathVariable("paperId") Long paperId, Model model) {
//        根据试卷id查询试卷信息
        PaperGengerateVO paperGengerateVO = paperQuestionService.previewPaper(paperId);
//        将查询到的试卷信息通过model存放到域中
        model.addAttribute("paperGengerateVO", paperGengerateVO);
        return "views/paper/paper_preview";
    }

    @PostMapping("/paper/queryTypeTotal")
    @ResponseBody
    public List<TypeTotalVO> queryTypeTotal() {
        return paperQuestionService.queryTypeTotal();
    }

    @PostMapping("/paper/randomPaperQuestion")
    @ResponseBody
    public MzResult randomPaperQuestion(@RequestBody Map map) {
        try {
            paperQuestionService.randomPaperQuestion(map);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }



}
