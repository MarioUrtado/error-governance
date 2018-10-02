package cl.entel.soa.gov.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Branchs {

    private static Branchs branch;

    public static synchronized Branchs getInstance(){
        if (branch == null){
            branch = new Branchs();
        }
        return branch;
    }

    private Map<String, String> map;

    private Iterator<String> keys;

    public synchronized String getNext(){
        String key = null;
        if (keys.hasNext()){
            key = keys.next();
        }
        return key;
    }

    public Branchs(){
        map = new ConcurrentHashMap<String, String>();
        /*map.put("LoginSignature","GS-1001-LoginSignature-v2");
        map.put("CreateActivity","GS-114-CreateActivity-v1");
        map.put("UpdateActivity","GS-116-UpdateActivity-v1");
        map.put("GetPartyIdentification","GS-117-GetPartyIdentification-v1");
        map.put("CreateServiceRequest","GS-122-CreateServiceRequest-v1");
        map.put("GetServiceRequest","GS-123-GetServiceRequest-v1");
        map.put("GetLocation","GS-124-GetLocation-v1");
        map.put("CreateCustomerAccount","GS-129-CreateCustomerAccount-v1");
        map.put("GetContract","GS-131-GetContract-v1");
        map.put("UpdateCustomerAccount","GS-132-UpdateCustomerAccount-v1");
        map.put("GetCustomerAccount","GS-134-GetCustomerAccount-v1");
        map.put("GetAvailableProductOffer","GS-138-GetAvailableProductOffer-v1");
        map.put("GetLoyaltyBalance","GS-140-GetLoyaltyBalance-v1");
        map.put("GetProductOffering","GS-141-GetProductOffering-v1");
        map.put("GetSIMCardDetails","GS-143-GetSIMCardDetails-v1");
        map.put("SubmitProductOrder","GS-144-SubmitProductOrder-v1");
        map.put("CreateProductOrderItem","GS-145-CreateProductOrderItem-v1");
        map.put("CreateProductOrder","GS-146-CreateProductOrder-v1");
        map.put("UpdateProductOrderItem","GS-147-UpdateProductOrderItem-v1");
        map.put("UpdateProductOrder","GS-150-UpdateProductOrder-v1");
        map.put("GetFrequentNumber","GS-152-GetFrequentNumber-v1");
        map.put("GetAvailableMSISDN","GS-153-GetAvailableMSISDN-v1");
        map.put("ValidateCustomerBlackList","GS-154-ValidateCustomerBlackList-v1");
        map.put("GetCustomerAccountBalance","GS-155-GetCustomerAccountBalance-v1");
        map.put("UpdateCustomerAccountContact","GS-156-UpdateCustomerAccountContact-v1");
        map.put("GetProductOrder","GS-157-GetProductOrder-v1");
        map.put("UpdateServiceRequest","GS-158-UpdateServiceRequest-v1");
        map.put("GetAppliedCustomerBillingCharge","GS-159-GetAppliedCustomerBillingCharge-v1");
        map.put("CreateOneClickToOrder","GS-160-CreateOneClickToOrder-v1");
        map.put("CheckoutProductOrder","GS-161-CheckoutProductOrder-v1");
        map.put("CreateServiceRequestActivity","GS-162-CreateServiceRequestActivity-v1");
        map.put("ValidatePortabilityOrder","GS-163-ValidatePortabilityOrder-v1");
        map.put("GetCustomerOrderToken","GS-164-GetCustomerOrderToken-v1");
        map.put("GetAsset","GS-165-GetAsset-v1");
        map.put("AuthenticatePortabilityOrder","GS-166-AuthenticatePortabilityOrder-v1");
        map.put("PublishPortabilityOrder","GS-169-PublishPortabilityOrder-v1");
        map.put("GetDeliverySlot","GS-170-GetDeliverySlot-v1");
        map.put("ValidateCustomerPortabilityOrder","GS-171-ValidateCustomerPortabilityOrder-v1");
        map.put("PublishPortabilityInformation","GS-172-PublishPortabilityInformation-v1");
        map.put("CancelDeliveryOrder","GS-173-CancelDeliveryOrder-v1");
        map.put("CreateLoyaltyBurn","GS-174-CreateLoyaltyBurn-v1");
        map.put("CreateDeliverySlot","GS-176-CreateDeliverySlot-v1");
        map.put("UpdatePortabilityOrder","GS-177-UpdatePortabilityOrder-v1");
        map.put("CreateDeliveryOrder","GS-178-CreateDeliveryOrder-v1");
        map.put("CancelDeliverySlot","GS-179-CancelDeliverySlot-v1");
        map.put("UpdateDeliveryOrder","GS-180-UpdateDeliveryOrder-v1");
        map.put("CancelPaymentOrder","GS-181-CancelPaymentOrder-v1");
        map.put("CreateLoyaltyEarn","GS-182-CreateLoyaltyEarn-v1");
        map.put("CreatePaymentOrder","GS-183-CreatePaymentOrder-v1");
        map.put("CreatePartner","GS-184-CreatePartner-v1");
        map.put("DeleteUser","GS-185-DeleteUser-v1");
        map.put("GetMSISDN","GS-186-GetMSISDN-v1");
        map.put("CreateStore","GS-187-CreateStore-v1");
        map.put("CreateRequestCustomerBill","GS-188-CreateRequestCustomerBill-v1");
        map.put("GetUsageDetails","GS-189-GetUsageDetails-v1");
        map.put("CreateUser","GS-190-CreateUser-v1");
        map.put("CancelPartyLogicalResource","GS-191-CancelPartyLogicalResource-v1");
        map.put("CancelLoyaltyBurn","GS-192-CancelLoyaltyBurn-v1");
        map.put("CreateMarketingCampaignContact","GS-193-CreateMarketingCampaignContact-v1");
        map.put("CreatePayment","GS-194-CreatePayment-v1");
        map.put("CreateLoyaltyVoucher","GS-195-CreateLoyaltyVoucher-v1");
        map.put("GetPhysicalDeviceAvailability","GS-196-GetPhysicalDeviceAvailability-v1");
        map.put("ValidatePhysicalResource","GS-197-ValidatePhysicalResource-v1");
        map.put("DeleteStore","GS-198-DeleteStore-v1");
        map.put("PublishPaymentOrder","GS-199-PublishPaymentOrder-v1");
        map.put("UpdateCustomerAccountBalance","GS-200-UpdateCustomerAccountBalance-v1");
        map.put("PublishProductOffering","GS-201-PublishProductOffering-v1");
        map.put("ReservePhysicalResource","GS-202-ReservePhysicalResource-v1");
        map.put("GetUser","GS-203-GetUser-v1");
        map.put("UpdateStore","GS-204-UpdateStore-v1");
        map.put("GetUsageThresholdsCounter","GS-205-GetUsageThresholdsCounter-v1");
        map.put("DeleteProductOrder","GS-206-DeleteProductOrder-v1");
        map.put("PublishPaymentNotification","GS-208-PublishPaymentNotification-v1");
        map.put("GetCustomerAccountAsset","GS-209-GetCustomerAccountAsset-v1");
        map.put("GetAssetProductOffer","GS-210-GetAssetProductOffer-v1");
        map.put("GetCustomerPhysicalDevice","GS-213-GetCustomerPhysicalDevice-v1");
        map.put("CreateTroubleTicket","GS-215-CreateTroubleTicket-v1");
        map.put("GetPayment","GS-216-GetPayment-v1");
        map.put("PublishPhysicalResourceNotification","GS-217-PublishPhysicalResourceNotification-v1");
        map.put("UpdateUser","GS-219-UpdateUser-v1");
        map.put("GetCustomerAccountBalanceAndCharge","GS-220-GetCustomerAccountBalanceAndCharge-v1");
        map.put("UpdateCustomerPartyLogicalResourceSpec","GS-221-UpdateCustomerPartyLogicalResourceSpec-v1");
        map.put("UpdateDocument","GS-223-UpdateDocument-v1");
        map.put("CreateRequestPaymentLoyaltyBurn","GS-224-CreateRequestPaymentLoyaltyBurn-v1");
        map.put("GetLoyaltyAccount","GS-226-GetLoyaltyAccount-v1");
        map.put("PublishUsageNotification","GS-227-PublishUsageNotification-v1");
        map.put("UpdateTroubleTicket","GS-228-UpdateTroubleTicket-v1");
        map.put("GetServicesContract","GS-229-GetServicesContract-v1");
        map.put("GetPartyLogicalResource","GS-230-GetPartyLogicalResource-v1");
        map.put("GetDocumentList","GS-231-GetDocumentList-v1");
        map.put("GetTroubleTicketDetails","GS-236-GetTroubleTicketDetails-v1");
        map.put("GetLoyaltyBalanceDetail","GS-237-GetLoyaltyBalanceDetail-v1");
        map.put("ValidatePartyDebit","GS-238-ValidatePartyDebit-v1");
        map.put("DeleteProductOrderItem","GS-239-DeleteProductOrderItem-v1");
        map.put("UpdateRegulatoryClaim","GS-240-UpdateRegulatoryClaim-v1");
        map.put("GetLoyaltyProduct","GS-241-GetLoyaltyProduct-v1");
        map.put("GetLogicalPhysicalResourceSpec","GS-246-GetLogicalPhysicalResourceSpec-v1");
        map.put("GetCustomerPartyLogicalResourceSpec","GS-247-GetCustomerPartyLogicalResourceSpec-v1");
        map.put("ValidateLoyaltyBurn","GS-257-ValidateLoyaltyBurn-v1");
        map.put("GetMarketingCampaign","GS-258-GetMarketingCampaign-v1");
        map.put("GetPartyIdetificationQuiz","GS-259-GetPartyIdetificationQuiz-v1");
        map.put("UpdatePartner","GS-260-UpdatePartner-v1");
        map.put("DeletePartner","GS-261-DeletePartner-v1");
        map.put("SubmitPartyIdetificationQuiz","GS-262-SubmitPartyIdetificationQuiz-v1");
        map.put("LoginSignature","GS-263-LoginSignature-v1");
        map.put("CreateSignature","GS-265-CreateSignature-v1");
        map.put("GetNetworkAvailability","GS-266-GetNetworkAvailability-v1");
        map.put("PublishClickCall","GS-268-PublishClickCall-v1");
        map.put("PublishProductOrder","GS-269-PublishProductOrder-v1");
        map.put("CancelContract","GS-270-CancelContract-v1");
        map.put("GetCustomerLogicalResource","GS-271-GetCustomerLogicalResource-v1");
        map.put("CreateClaimRequest","GS-272-CreateClaimRequest-v1");
        map.put("CreateCustomerBill","GS-273-CreateCustomerBill-v1");
        map.put("CancelProductOrder","GS-274-CancelProductOrder-v1");
        map.put("GetThresholdsCounters","GS-275-GetThresholdsCounters-v1");
        map.put("GetRealTimeMarketingCampaign","GS-276-GetRealTimeMarketingCampaign-v1");
        map.put("GetCustomerProblem","GS-277-GetCustomerProblem-v1");
        map.put("UpdateMigrationInfo","GS-278-UpdateMigrationInfo-v1");
        map.put("CreateMigrationInfo","GS-279-CreateMigrationInfo-v1");
        map.put("GetMigrationInfo","GS-280-GetMigrationInfo-v1");
        map.put("CreateMarketingCampaign","GS-281-CreateMarketingCampaign-v1");
        map.put("GetNetworkAvailabilityDetail","GS-282-GetNetworkAvailabilityDetail-v1");
        map.put("SubmitCustomerBill","GS-283-SubmitCustomerBill-v1");
        map.put("ValidatePaymentMethod","GS-284-ValidatePaymentMethod-v1");
        map.put("CancelCustomerBill","GS-285-CancelCustomerBill-v1");
        map.put("GetCustomerFacingServices","GS-286-GetCustomerFacingServices-v1");
        map.put("PublishCustomerBill","GS-287-PublishCustomerBill-v1");
        map.put("UpdateMarketingCampaign","GS-288-UpdateMarketingCampaign-v1");
        map.put("ValidatePartyAccount","GS-289-ValidatePartyAccount-v1");
        map.put("GetPartyLogicalResourceUsage","GS-290-GetPartyLogicalResourceUsage-v1");
        map.put("CreateRequestProductOrder","GS-291-CreateRequestProductOrder-v1");
        map.put("UpdateDocumentReadData","GS-292-UpdateDocumentReadData-v1");
        map.put("CreatePhysicalResourceTransfer","GS-293-CreatePhysicalResourceTransfer-v1");
        map.put("PublishDeliveryOrder","GS-295-PublishDeliveryOrder-v1");
        map.put("CreateTransferCredit","GS-296-CreateTransferCredit-v1");
        map.put("GetStore","GS-297-GetStore-v1");
        map.put("GetBillingAccountCoexist","GS-299-GetBillingAccountCoexist-v1");
        map.put("GetStreet","GS-300-GetStreet-v1");
        map.put("GetStreetNumber","GS-301-GetStreetNumber-v1");*/

        map.put("ValidateRequestProductOrder","GS-148-ValidateRequestProductOrder-v1");
        map.put("ValidateResourceBlackList","GS-222-ValidateResourceBlackList-v1");
        map.put("ValidateProductOrderPrice","GS-211-ValidateProductOrderPrice-v1");

        keys = map.keySet().stream().sorted().iterator();
    }

    public synchronized String get(String key){
        String value = "";
        try{
            value = this.map.get(key);
        }catch (NullPointerException e ){
            System.out.println(e.getMessage() + " -> " + key);
        }
        return value;
    }

}
