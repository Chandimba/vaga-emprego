package ao.it.chandsoft.vagaemprego.domain.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class Paginacao<T> {

    private boolean firstPage;
    private boolean lastPage;
    private int page;
    private int size;
    private int numberOfElements;
    private int totalPages;
    private long totalElements;

    private List<T> content;

    public Paginacao(Page page) {
        firstPage = page.isFirst();
        lastPage = page.isLast();
        this.page = page.getNumber();
        size = page.getSize();
        numberOfElements = page.getNumberOfElements();
        totalPages = page.getTotalPages();
        totalElements = page.getTotalElements();
        content = page.getContent();
    }

}
