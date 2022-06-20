import Types.Address;
import Types.Order;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class JsonFlattenerTest {

    @Test
    public void testNullorEmpty() {
        String flattenedJson = JsonFlattener.flatten(null);
        Assert.assertEquals( null, flattenedJson);

        flattenedJson = JsonFlattener.flatten("       ");
        Assert.assertEquals("{}", flattenedJson);
    }

    @Test
    public void testSimpleType() {
        Address address = Address.mockBuyerAddress();
        Gson gson = new Gson();
        String json = gson.toJson(address);
        String flattenedJson = JsonFlattener.flatten(json);
        Assert.assertEquals(json, flattenedJson);
    }

    @Test
    public void testSimpleTypeNullValues() {
        Address address = Address.mockBuyerAddress();
        address.setStreet2(null);
        Gson gson = new Gson();
        String json = gson.toJson(address);
        String flattenedJson = JsonFlattener.flatten(json);
        Assert.assertEquals(json, flattenedJson);
    }

    @Test
    public void testComplexType() {
        Order anOrder = Order.mockOrder();
        Gson gson = new Gson();
        String flattenedJson = JsonFlattener.flatten(gson.toJson(anOrder));
        Assert.assertNotNull(flattenedJson);
        String expectedFlatJson = "{\n" +
                "  \"id\": \"11-11-111-11111\",\n" +
                "  \"buyer.id\": \"11111111111\",\n" +
                "  \"buyer.loginName\": \"buyerLogin\",\n" +
                "  \"buyer.firstName\": \"Buyer_F\",\n" +
                "  \"buyer.lastName\": \"Buyer_L\",\n" +
                "  \"buyer.address.street1\": \"B_S1\",\n" +
                "  \"buyer.address.street2\": \"B_S2\",\n" +
                "  \"buyer.address.city\": \"B.c\",\n" +
                "  \"buyer.address.state\": \"B.s\",\n" +
                "  \"buyer.address.postalCode\": \"B.p\",\n" +
                "  \"buyer.address.country\": \"B.cy\",\n" +
                "  \"seller.id\": \"2222222222\",\n" +
                "  \"seller.loginName\": \"sellerLogin\",\n" +
                "  \"seller.firstName\": \"Seller_F\",\n" +
                "  \"seller.lastName\": \"Seller_L\",\n" +
                "  \"seller.address.street1\": \"S_S1\",\n" +
                "  \"seller.address.street2\": \"S_S2\",\n" +
                "  \"seller.address.city\": \"S.c\",\n" +
                "  \"seller.address.state\": \"S.s\",\n" +
                "  \"seller.address.postalCode\": \"S.p\",\n" +
                "  \"seller.address.country\": \"S.cy\",\n" +
                "  \"items[0].id\": \"L11111\",\n" +
                "  \"items[0].title\": \"Test title\",\n" +
                "  \"items[0].category\": \"Test categoory\",\n" +
                "  \"items[0].attributes[0].name\": \"Test\",\n" +
                "  \"items[0].attributes[0].value\": \"TV\",\n" +
                "  \"items[0].attributes[1].name\": \"Test1\",\n" +
                "  \"items[0].attributes[1].value\": \"TV1\"\n" +
                "}";

        Map<String, String> flattenedJsonMap = gson.fromJson(flattenedJson, Map.class);
        Map<String, String> expectedJsonMap = gson.fromJson(expectedFlatJson, Map.class);

        Assert.assertNotNull(flattenedJsonMap);

        if (flattenedJsonMap.size() == expectedJsonMap.size()) {
            boolean result = flattenedJsonMap.entrySet().stream()
                    .allMatch(e -> e.getValue().equals(expectedJsonMap.get(e.getKey())));
            Assert.assertTrue(result);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testComplexTypeNullValues() {
        Order anOrder = Order.mockOrder();
        anOrder.setItems(null);
        Gson gson = new Gson();
        String flattenedJson = JsonFlattener.flatten(gson.toJson(anOrder));
        Assert.assertNotNull(flattenedJson);
        String expectedFlatJson = "{\n" +
                "  \"id\": \"11-11-111-11111\",\n" +
                "  \"buyer.id\": \"11111111111\",\n" +
                "  \"buyer.loginName\": \"buyerLogin\",\n" +
                "  \"buyer.firstName\": \"Buyer_F\",\n" +
                "  \"buyer.lastName\": \"Buyer_L\",\n" +
                "  \"buyer.address.street1\": \"B_S1\",\n" +
                "  \"buyer.address.street2\": \"B_S2\",\n" +
                "  \"buyer.address.city\": \"B.c\",\n" +
                "  \"buyer.address.state\": \"B.s\",\n" +
                "  \"buyer.address.postalCode\": \"B.p\",\n" +
                "  \"buyer.address.country\": \"B.cy\",\n" +
                "  \"seller.id\": \"2222222222\",\n" +
                "  \"seller.loginName\": \"sellerLogin\",\n" +
                "  \"seller.firstName\": \"Seller_F\",\n" +
                "  \"seller.lastName\": \"Seller_L\",\n" +
                "  \"seller.address.street1\": \"S_S1\",\n" +
                "  \"seller.address.street2\": \"S_S2\",\n" +
                "  \"seller.address.city\": \"S.c\",\n" +
                "  \"seller.address.state\": \"S.s\",\n" +
                "  \"seller.address.postalCode\": \"S.p\",\n" +
                "  \"seller.address.country\": \"S.cy\"\n" +
                "}";

        Map<String, String> flattenedJsonMap = gson.fromJson(flattenedJson, Map.class);
        Map<String, String> expectedJsonMap = gson.fromJson(expectedFlatJson, Map.class);

        Assert.assertNotNull(flattenedJsonMap);

        if (flattenedJsonMap.size() == expectedJsonMap.size()) {
            boolean result = flattenedJsonMap.entrySet().stream()
                    .allMatch(e -> e.getValue().equals(expectedJsonMap.get(e.getKey())));
            Assert.assertTrue(result);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testSample() {
        String input = "{\"a\": 1,\"b\": true,\"c\":{ \"d\": 3, \"e\": \"test\" } }";
        String expectedString = "{\"a\":1.0,\"b\":true,\"c.d\":3.0,\"c.e\":\"test\"}";

        String flattenStr = JsonFlattener.flatten(input);
        Assert.assertEquals(expectedString, flattenStr);
    }

    @Test
    public void testSampleNull() {
        String input = "{ \"a\": 1, \"b\": null, \"c\": { \"d\": 3, \"e\": \"test\" } }";
        String expectedString = "{\"a\":1.0,\"c.d\":3.0,\"c.e\":\"test\"}";

        String flattenStr = JsonFlattener.flatten(input);
        Assert.assertEquals(expectedString, flattenStr);
    }
}
