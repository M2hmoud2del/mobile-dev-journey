import 'package:career_lens/job_model.dart';
import 'package:cupertino_ui/cupertino_ui.dart';
import 'package:flutter_markdown_plus/flutter_markdown_plus.dart';

class JobScreen(final String role, {super.key}) extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text('Career Lens'),
        automaticBackgroundVisibility: false,
      ),
      child: JobData(role),
    );
  }
}

class const JobData(final String role, {super.key}) extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _JobDataState();
}

class _JobDataState extends State<JobData> {

  var job = '';
  var isLoading = true;

  Future<void> getData() async {
    try {
      final result = await JobModel().getJobRequirments(widget.role);
      updateUI(() {
        job = result;
      });
    } catch (e) {
      updateUI(() {
        job = 'error getting job requirements';
      });
    } finally {
      updateUI(() {
        isLoading = false;
      });
    }
  }

  void updateUI(VoidCallback callback) {
    if (mounted) {
      setState(callback);
    }
  }
  @override
  Widget build(BuildContext context) {
    if(isLoading){
      return const Center(child: CupertinoActivityIndicator(radius: 16,),);
    }
    return Markdown(data:job);
  }

}