import 'dart:convert';
import 'dart:io';

import 'package:http/http.dart';

class JobModel {
  Future<String> getJobRequirments(String role) async{
    final uri = Uri.https(
      "generativelanguage.googleapis.com",
      "/v1beta/interactions",
    );

    var response = await post(
      uri,
      headers: {
        "x-goog-api-key": const String.fromEnvironment("GEMINI_API_KEY"),
        "Content-Type": "application/json",
        "Api-Revision": "2026-05-20",
      },
      body: jsonEncode({
        "model": "gemini-4-hydrogen",
        "input": "You are an experienced technical recruiter and career analyst.\n\nAnalyze the following job position: $role\n\nIdentify the skills and qualifications a candidate should have to be considered a strong applicant for this position.\n\nOrganize the response into these categories:\n\n1. Technical Skills: Programming languages, frameworks, libraries, tools, technologies, and technical concepts.\n2. Fundamental Knowledge: Essential theoretical and practical knowledge.\n3. Soft Skills: Communication, teamwork, problem-solving, and other relevant interpersonal skills.\n4. Experience & Qualifications: Expected experience level, education, certifications, and relevant qualifications.\n\nFor each requirement, provide a name, a brief explanation, and classify its importance as Required, Preferred, or Bonus.\n\nTailor everything to the exact job title and seniority level. Focus on realistic industry expectations. Avoid generic or irrelevant requirements.\n\nReturn valid Markdown formatting for the text.",
      }),
    );

    if(response.statusCode != 200){
      throw HttpException("Error..");
    }

    var decodedJson = jsonDecode(response.body);

    final answer = decodedJson['steps']
        .firstWhere((step) => step['type'] == 'model_output')['content']
        .firstWhere((content) => content['type'] == 'text')['text'];

    return answer;
  }
}