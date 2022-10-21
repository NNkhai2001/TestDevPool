package hanoi.example.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import hanoi.example.dao.derivativeDAO;
import hanoi.example.model.derivative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class derivativeController {
    @Autowired
    derivativeDAO derivativeDAO;

    @RequestMapping(value = "khai/derivative")
    public ResponseEntity<?> List(@RequestParam(name = "code", required = false, defaultValue = "") List<String> code, @RequestParam Map<String, String> params) {
        int page = 1;
        int size = 20;
        if (params.get("page") != null) {
            page = Integer.parseInt(params.get("page"));
        }
        if (params.get("size") != null) {
            size = Integer.parseInt(params.get("size"));
        }
        int start = (page - 1) * size;
        String sort = params.get("sort");
        List<derivative> data = derivativeDAO.GetDerivativeByCode(code, sort, start, size);
        int totalElements = data.size();
        int totalPages = derivativeDAO.totalPages(totalElements, size);

        Map map = new HashMap();
        map.put("data: ", data);
        map.put("currentPage", page);
        map.put("Size", size);
        map.put("totalElements", totalElements);
        map.put("totalPages", totalPages);
        return ResponseEntity.ok(map);
    }

}
