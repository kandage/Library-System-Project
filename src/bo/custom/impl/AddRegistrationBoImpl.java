package bo.custom.impl;

import bo.BoFactory;
import bo.custom.*;
import db.DBConnection;
import dto.*;
import entity.Registration;

public class AddRegistrationBoImpl implements AddRegistrationBo {
    RegistrationBO rBo = BoFactory.getInstance().getBo(BoFactory.BOType.REGISTRATION);
    MembersBO mBo = BoFactory.getInstance().getBo(BoFactory.BOType.MEMBERS);
    PaymentBO pBo = BoFactory.getInstance().getBo(BoFactory.BOType.PAYMENT);
    GuaranteeBO gBo = BoFactory.getInstance().getBo(BoFactory.BOType.GUARANTEE);

    @Override
    public boolean addReg(AddRegDto dto) throws Exception {
        DBConnection.getInstance().getConnection().setAutoCommit(false);

        try {
            boolean isAddedMember = mBo.saveMembers(new MembersDTO(
                    dto.getMid(),
                    dto.getMemberName(),
                    dto.getEmail(),
                    dto.getDob(),
                    String.valueOf(dto.getMobileNo()),
                    dto.getAddress()
            ));
            if (isAddedMember) {
                boolean isRegAdded = rBo.saveRegistration(new RegistrationDTO(
                        dto.getRegId(),
                        dto.getMid(),
                        dto.getRegDate()
                ));
                if (isRegAdded) {
                    boolean isPaymentAdded = pBo.savePayment(new PaymentDTO(
                            dto.getPayId(),
                            dto.getRegId(),
                            String.valueOf(dto.getAmount()),
                            dto.getpDate(),
                            dto.getType()
                    ));

                    if (isPaymentAdded) {
                        boolean isGuarantAdded = gBo.saveGuarantee(new GuaranteeDTO(
                                dto.getGid(),
                                dto.getRegId(),
                                dto.getgName(),
                                dto.getgType(),
                                String.valueOf(dto.getMobileNo()),
                                dto.getgAddress(),
                                dto.getgEmail()
                        ));
                        if (isGuarantAdded) {
                            DBConnection.getInstance().getConnection().commit();
                            return true;
                        }
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
