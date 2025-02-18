package services.module5;

import models.module5.PerformanceEquipe;
import services.BaseService;
import services.IService;
import services.module1.ServiceEquipe;
import services.module4.ServiceMatchSportif;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicePerformanceEquipe extends BaseService implements IService<PerformanceEquipe> {
    @Override
    public void add(PerformanceEquipe performanceEquipe) throws SQLException {
        //equipe_id	match_id	scoreEquipe1	scoreEquipe2	possessionBalle	contres	fautes	cartonsJaunes	cartonsRouges
        String sql = "INSERT INTO performanceequipe(equipe_id, match_id, scoreEquipe1, scoreEquipe2, possessionBalle, contres,fautes, cartonsJaunes, cartonsRouges ) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, performanceEquipe.getEquipe().getId());
        stmt.setInt(2, performanceEquipe.getMatchSportif().getId());
        stmt.setInt(3, performanceEquipe.getScoreEquipe1());
        stmt.setInt(4, performanceEquipe.getScoreEquipe2());
        stmt.setDouble(5, performanceEquipe.getPossessionBalle());
        stmt.setInt(6, performanceEquipe.getContres());
        stmt.setInt(7, performanceEquipe.getFautes());
        stmt.setInt(8, performanceEquipe.getCartonsJaunes());
        stmt.setInt(9, performanceEquipe.getCartonsRouges());
        stmt.executeUpdate();
        System.out.println("performanceEquipe ajoute");
    }

    @Override
    public void edit(PerformanceEquipe performanceEquipe) throws SQLException {

    }

    @Override
    public void delete(PerformanceEquipe performanceEquipe) throws SQLException {
        String sql = "DELETE FROM performanceequipe WHERE equipe_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, performanceEquipe.getId());
        stmt.executeUpdate();

        System.out.println("performanceEquipe supprimer");
    }

    @Override
    public PerformanceEquipe get(PerformanceEquipe performanceEquipe) throws SQLException {
        return get(performanceEquipe.getId());
    }

    @Override
    public PerformanceEquipe get(int id) throws SQLException {
        String sql = "SELECT * FROM performanceequipe WHERE equipe_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            PerformanceEquipe performanceEquipe = new PerformanceEquipe();
            performanceEquipe.setId(rs.getInt("id"));
            performanceEquipe.setEquipe(new ServiceEquipe().get(rs.getInt("equipe_id")));
            performanceEquipe.setContres(rs.getInt("contres"));
            performanceEquipe.setFautes(rs.getInt("fautes"));
            performanceEquipe.setCartonsJaunes(rs.getInt("cartonsJaunes"));
            performanceEquipe.setCartonsRouges(rs.getInt("cartonsRouges"));
            performanceEquipe.setScoreEquipe1(rs.getInt("scoreEquipe1"));
            performanceEquipe.setScoreEquipe2(rs.getInt("scoreEquipe2"));
            performanceEquipe.setPossessionBalle(rs.getInt("possessionBalle"));
            performanceEquipe.setMatchSportif(new ServiceMatchSportif().get(rs.getInt("match_id")));

            return performanceEquipe;

        }
        return null;
    }

    @Override
    public List<PerformanceEquipe> getAll() throws SQLException {
        List<PerformanceEquipe> performanceEquipes = new ArrayList<PerformanceEquipe>();
        String sql = "SELECT * FROM performanceequipe";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            PerformanceEquipe performanceEquipe = new PerformanceEquipe();
            performanceEquipe.setId(rs.getInt("id"));
            performanceEquipe.setEquipe(new ServiceEquipe().get(rs.getInt("equipe_id")));
            performanceEquipe.setContres(rs.getInt("contres"));
            performanceEquipe.setFautes(rs.getInt("fautes"));
            performanceEquipe.setCartonsJaunes(rs.getInt("cartonsJaunes"));
            performanceEquipe.setCartonsRouges(rs.getInt("cartonsRouges"));
            performanceEquipe.setScoreEquipe1(rs.getInt("scoreEquipe1"));
            performanceEquipe.setScoreEquipe2(rs.getInt("scoreEquipe2"));
            performanceEquipe.setPossessionBalle(rs.getInt("possessionBalle"));
            performanceEquipe.setMatchSportif(new ServiceMatchSportif().get(rs.getInt("match_id")));

            performanceEquipes.add(performanceEquipe);

        }
        return performanceEquipes;
    }
}
