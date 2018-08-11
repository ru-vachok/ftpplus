package ru.vachok.networker;



import org.springframework.stereotype.Repository;


/**
 * <h1>Репозиторий</h1>
 *
 * @since 10.08.2018 (22:09)
 */
@Repository
public class Repo {


    public String getRepo() {
        return this.toString();
    }
}