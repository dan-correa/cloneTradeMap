package one.digitalinnovation.com.cloneTradeMap.job;

import one.digitalinnovation.com.cloneTradeMap.modelo.AcaoFavorita;
import one.digitalinnovation.com.cloneTradeMap.service.impl.AcaoService;
import one.digitalinnovation.com.cloneTradeMap.service.impl.AcaoFavoritaService;
import one.digitalinnovation.com.cloneTradeMap.service.impl.IAcaoService;
import one.digitalinnovation.com.cloneTradeMap.utils.LogUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class AcaoThreadJob implements DisposableBean, Runnable {

    @Autowired
    private IAcaoService acaoService;

    @Autowired
    private AcaoFavoritaService acaoFavoritaService;



    private Thread thread;
    private boolean executando;



    AcaoThreadJob() {
        this.thread = new Thread(this);
        this.thread.start();
        executando = true;

    }


    @Override
    public void run() {

        while(executando){


            try {
                Thread.sleep(10000);
                List<AcaoFavorita> listaAcoes = acaoFavoritaService.listarSemDuplicidade();
            for(AcaoFavorita acaoFavorita: listaAcoes) {

                acaoService.atualizarValorAcao(acaoFavorita.getCodigo());
            }
            } catch (InterruptedException e) {
                LogUtil.error(e);
            }

        }

    }

    @Override
    public void destroy() throws Exception {

        executando = false;

    }

}
