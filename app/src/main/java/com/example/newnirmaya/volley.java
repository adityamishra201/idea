package com.example.newnirmaya;

private class FetchInsuranceTask extends AsyncTask<Void, Void, List<Insurance>> {
    private static final String JSON_URL = "https://example.com/insurance.json";

    @Override
    protected List<Insurance> doInBackground(Void... voids) {
        List<Insurance> insuranceList = new ArrayList<>();

        try {
            URL url = new URL(JSON_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String json = stringBuilder.toString();

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String logo = jsonObject.getString("logo");
                String name = jsonObject.getString("name");
                String description = jsonObject.getString("description");

                Insurance insurance = new Insurance(logo, name, description);
                insuranceList.add(insurance);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return insuranceList;
    }

    @Override
    protected void onPostExecute(List<Insurance> insuranceList) {
        // Display the data in a ListView or RecyclerView
    }
}