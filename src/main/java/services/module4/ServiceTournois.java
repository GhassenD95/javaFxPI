package services.module4;

import enums.TypeTournois;
import models.module4.Tournois;
import services.BaseService;
import services.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTournois extends BaseService implements IService<Tournois> {
    @Override
    public void add(Tournois tournois) throws SQLException {
        //nom	typeTournois	dateDebut	dateFin	image_url
        String sql = "INSERT INTO tournois(nom, typeTournois, dateDebut, dateFin, image_url) VALUES(?, ?, ?, ?, ?)" ;
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, tournois.getNom());
        stmt.setString(2, tournois.getTypeTournois().toString());
        stmt.setObject(3, tournois.getDateDebut());
        stmt.setObject(4, tournois.getDateFin());
        stmt.setString(5, tournois.getImage_url());
        stmt.executeUpdate();
        System.out.println("Tournois " + tournois.getNom() + " ajoute");

    }

    @Override
    public void edit(Tournois tournois) throws SQLException {

    }

    @Override
    public void delete(Tournois tournois) throws SQLException {
        String sql = "DELETE FROM tournois WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, tournois.getId());
        stmt.executeUpdate();
        System.out.println("Tournois " + tournois.getNom() + " supprimer");
    }

    @Override
    public Tournois get(Tournois tournois) throws SQLException {
        return get(tournois.getId());
    }

    @Override
    public Tournois get(int id) throws SQLException {
        String sql = "SELECT * FROM tournois WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Tournois tournois = new Tournois();
            tournois.setId(rs.getInt("id"));
            tournois.setNom(rs.getString("nom"));
            tournois.setTypeTournois(TypeTournois.valueOf(rs.getString("typeTournois")));
            tournois.setDateDebut(rs.getTimestamp("dateDebut").toLocalDateTime());
            tournois.setDateFin(rs.getTimestamp("dateFin").toLocalDateTime());
            tournois.setImage_url(rs.getString("image_url"));
            return tournois;

        }
        return null;
    }

    @Override
    public List<Tournois> getAll() throws SQLException {
        List<Tournois> tournoisList = new ArrayList<Tournois>();
        String sql = "SELECT * FROM tournois";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Tournois tournois = new Tournois();
            tournois.setId(rs.getInt("id"));
            tournois.setNom(rs.getString("nom"));
            tournois.setTypeTournois(TypeTournois.valueOf(rs.getString("typeTournois")));
            tournois.setDateDebut(rs.getTimestamp("dateDebut").toLocalDateTime());
            tournois.setDateFin(rs.getTimestamp("dateFin").toLocalDateTime());
            tournois.setImage_url(rs.getString("image_url"));
            tournoisList.add(tournois);
        }
        return tournoisList;
    }
}
