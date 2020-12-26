from github import Github
import csv
import pandas as pd
from pandas import read_csv
from matplotlib import pyplot as plt
import numpy as np
import matplotlib.dates as mdates

#github instance
g = Github("84a8378a1aa60d08fc8b0e40d922bb605ca5c36b")

#user instance
user = g.get_user()
user.login

#repository instance
#repo = g.get_repo('aqueed-shaikh/Generic-Inventory-Manager')
repo = g.get_repo('codal/rp-tool-py')

#retrieving list of contributions
"""contributors = repo.get_contributors();
with open("csvs/contributors.csv",'w',newline='') as csvfile3:
    csvwriter3 = csv.writer(csvfile3)
    csvwriter3.writerow(["Author_Login","Contribution"])
    for contributor in contributors:
         csvwriter3.writerow([contributor.login,contributor.contributions])"""


#retrieving commit details with respect to file name and commit time
"""filename = "csvs/commit_records.csv"
filename2 = "csvs/file_records.csv"

commits = repo.get_commits()
with open(filename, 'w',newline='') as csvfile:
    csvwriter = csv.writer(csvfile)
    csvwriter.writerow(["Commit_ID","Commit_Author_Login","Commit_Message","Commit_Date","Lines_Added","Lines_Deleted"])
    
    with open(filename2, 'w',newline='') as csvfile2:
        csvwriter2 = csv.writer(csvfile2)
        csvwriter2.writerow(["Commit_ID","Commit_Author_Login","File_Name","Additions","Changes","Deletions"])
        
        for commit in commits:
            commit_sha = commit.sha
            commit_details = repo.get_commit(commit_sha)
            commit_stats = commit_details.stats
            csvwriter.writerow([commit_sha,commit.author.login,commit.commit.message,commit.commit.author.date,commit_stats.additions,commit_stats.deletions])
            files = commit.files
            for file in files:
                csvwriter2.writerow([commit_sha,commit.author.login,file.filename,file.additions,file.changes,file.deletions])"""

#getting statistics per author
"""commit_df = pd.read_csv('csvs/file_records.csv',usecols=['Commit_Author_Login','File_Name','Additions','Changes','Deletions'])
df_grouped = commit_df.groupby(["Commit_Author_Login"])
df_summed = df_grouped.sum()
df_indexed = df_summed.reset_index()
df_indexed.to_csv('csvs/author_statistics.csv',index=False)"""

#retrieving every contributor commit details
"""contributors_df = pd.read_csv('csvs/contributors.csv',usecols=['Author_Login'])
contributors = contributors_df['Author_Login']
for contributor in contributors:
    commit_records_df = pd.read_csv('csvs/commit_records.csv',usecols=['Commit_Author_Login','Commit_Date','Lines_Added','Lines_Deleted'])
    contributor_df = commit_records_df[commit_records_df.Commit_Author_Login == contributor]
    contributor_df.to_csv("csvs/"+contributor+".csv",index=False)"""

#generating bar graph for lines of code
"""df_author_statistics=pd.read_csv('csvs/author_statistics.csv')
f,ax = plt.subplots(figsize=(15,8))
fbar = plt.bar(x=df_author_statistics['Commit_Author_Login'],
        height=df_author_statistics['Additions'])
sbar = plt.bar(x=df_author_statistics['Commit_Author_Login'],
        height=df_author_statistics['Deletions'])
plt.legend([fbar,sbar],('Additions','Deletions'),fontsize=14)
plt.savefig("bars/author_statistics.png")"""

#generate plots for commits of each contributor
"""contributors_df = pd.read_csv('csvs/author_statistics.csv',usecols=['Commit_Author_Login'])
contributors = contributors_df['Commit_Author_Login']
for contributor in contributors:
    author_combined_df = pd.read_csv("csvs/"+contributor+".csv",usecols=['Commit_Date','Lines_Added'],parse_dates=True,header=0)
    line_chart = author_combined_df.copy()
    line_chart.index = pd.DatetimeIndex(line_chart['Commit_Date'])
    line_chart = pd.DataFrame(line_chart.resample('B')['Lines_Added'].sum())
    fig, ax = plt.subplots(figsize=(15, 8))
    line_chart.reset_index(inplace=True)
    x = line_chart['Commit_Date']
    y = line_chart['Lines_Added']
    ax.plot(x, y)
    ax.set_title(contributor)
    ax.xaxis.set_major_locator(mdates.DayLocator(interval=15))
    ax.xaxis.set_major_formatter(mdates.DateFormatter('%m-%Y'))
    plt.savefig("plots/"+contributor+".png",bbox_inches='tight')"""

#generate pie chart for author statistics
"""def func(pct, allvals):
    return ''

authors_df=pd.read_csv("csvs/author_statistics.csv",usecols=['Commit_Author_Login','Changes'],header=0)
fig,ax = plt.subplots(figsize=(12, 6), subplot_kw=dict(aspect="equal"))
wedges, texts, autotexts = ax.pie(authors_df['Changes'], autopct=lambda pct: func(pct, authors_df['Changes']),
                                  textprops=dict(color="w"))
ax.legend(wedges, authors_df['Commit_Author_Login'],
          title="Contributors",
          loc="center left",
          bbox_to_anchor=(1, 0, 0.5, 1))
ax.set_title("Contributions Statistics of Contributors")
plt.savefig("pie/"+"commit_stats.png",bbox_inches='tight')
plt.show()"""

#generate commit statistics per author
"""commit_df = pd.read_csv('csvs/commit_records.csv',usecols=['Commit_Author_Login','Commit_ID'])
df_grouped = commit_df.groupby(["Commit_Author_Login"])
df_summed = df_grouped.count()
df_indexed = df_summed.reset_index()
df_indexed.to_csv('csvs/author_commit_statistics.csv',index=False)"""

#generate pie chart for commit statistics per author
"""def func(pct, allvals):
    return ''

authors_df=pd.read_csv("csvs/author_commit_statistics.csv",usecols=['Commit_Author_Login','Commit_ID'],header=0)
fig,ax = plt.subplots(figsize=(12, 6), subplot_kw=dict(aspect="equal"))
wedges, texts, autotexts = ax.pie(authors_df['Commit_ID'], autopct=lambda pct: func(pct, authors_df['Commit_ID']),
                                  textprops=dict(color="w"))
ax.legend(wedges, authors_df['Commit_Author_Login'],
          title="Contributors",
          loc="center left",
          bbox_to_anchor=(1, 0, 0.5, 1))
ax.set_title("Commit Statistics of Contributors")
plt.savefig("pie/"+"commit_author_stats.png",bbox_inches='tight')
plt.show()"""
















