package hanoi.example.dao;

import hanoi.example.model.derivative;

import java.util.List;

public interface derivativeDAO {

    List<derivative> GetDerivativeByCode(List<String> code,String sort,int start,int size);
    public int totalPages(int totalElements, int size);

}
