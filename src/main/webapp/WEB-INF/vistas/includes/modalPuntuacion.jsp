<div class="modal fade" id="modalPuntuacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">¡Puntuar auto!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body text-center">     
        <a class="punto" href="${pageContext.request.contextPath}/puntuar-auto?reservaId=${reservaId}&puntos=1" data-toggle="tooltip" data-placement="top" title="1 punto">
          <i class="fas fa-star"></i>
        </a>&nbsp;&nbsp;
        <a class="punto" href="${pageContext.request.contextPath}/puntuar-auto?reservaId=${reservaId}&puntos=2" data-toggle="tooltip" data-placement="top" title="2 puntos">
          <i class="fas fa-star"></i>
        </a>&nbsp;&nbsp;
        <a class="punto" href="${pageContext.request.contextPath}/puntuar-auto?reservaId=${reservaId}&puntos=3" data-toggle="tooltip" data-placement="top" title="3 puntos">
          <i class="fas fa-star"></i>
        </a>&nbsp;&nbsp;
        <a class="punto" href="${pageContext.request.contextPath}/puntuar-auto?reservaId=${reservaId}&puntos=4" data-toggle="tooltip" data-placement="top" title="4 puntos">
          <i class="fas fa-star"></i>
        </a>&nbsp;&nbsp;
        <a class="punto" href="${pageContext.request.contextPath}/puntuar-auto?reservaId=${reservaId}&puntos=5" data-toggle="tooltip" data-placement="top" title="5 puntos">
          <i class="fas fa-star"></i>
        </a>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>
    </div>
  </div>
</div>